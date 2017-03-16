package com.yevgen.controller;

import com.yevgen.model.Contact;
import com.yevgen.model.User;
import com.yevgen.service.interfaces.ContactService;
import com.yevgen.service.interfaces.UserService;
import com.yevgen.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContactsController {
    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String getContacts(ModelMap model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("modalDisplay", "none");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Contact> userContacts = contactService.getAllContacts(authentication.getName());
        model.addAttribute("contactList", userContacts);
        return "contacts";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public String addContact(@ModelAttribute Contact contact, ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByLogin(authentication.getName());
        String modalDisplay = "none";
        boolean hasError = false;
        boolean hasEmptyField = contact.getFirstName() == null || contact.getSecondName() == null ||
                contact.getPatronymic() == null || contact.getMobilePhoneNumber() == null;
        String mobilePhoneNumberString = "" + contact.getMobilePhoneNumber();
        String homePhoneNumberString = "" + contact.getHomePhoneNumber();
        if (contact.getFirstName().length() < Constants.MIN_FIRST_NAME_LENGTH) {
            hasError = true;
            model.addAttribute("firstNameLengthError", Constants.FIRST_NAME_LENGTH_ERROR);
        }
        if (contact.getFirstName().length() < Constants.MIN_LAST_NAME_LENGTH) {
            hasError = true;
            model.addAttribute("LastNameLengthError", Constants.LAST_NAME_LENGTH_ERROR);
        }
        if (contact.getFirstName().length() < Constants.MIN_PATRONYMIC_LENGTH) {
            hasError = true;
            model.addAttribute("patronymicLengthError", Constants.PATRONYMIC_LENGTH_ERROR);
        }
        if (!mobilePhoneNumberString.matches(Constants.PHONE_NUMBER_REGEX_FOR_VALIDATION)) {
            hasError = true;
            model.addAttribute("phoneNumberFormatError", Constants.PHONE_NUMBER_FORMAT_ERROR);
        }
        if (!contact.getHomePhoneNumber().equals("") &&
                !homePhoneNumberString.matches(Constants.PHONE_NUMBER_REGEX_FOR_VALIDATION)) {
            hasError = true;
            model.addAttribute("homeNumberFormatError", Constants.PHONE_NUMBER_FORMAT_ERROR);
        }
        if (hasEmptyField) {
            hasError = true;
            model.addAttribute("emptyFieldError", Constants.EMPTY_FIELD_ERROR);
            model.addAttribute("contact", new Contact());
        }
        if (hasError) modalDisplay = "display";
        else {
            contact.setUser(user);
            contactService.create(contact);
        }
        System.out.println(contact.getFirstName());
        List<Contact> userContacts = contactService.getAllContacts(authentication.getName());
        model.addAttribute("contactList", userContacts);
        model.addAttribute("modalDisplay", modalDisplay);
        return "contacts";
    }

    @RequestMapping(name = "/contacts/delete", method = RequestMethod.GET, params = {"contactId"})
    public String deleteContact(@RequestParam("contactId") Long contactId, ModelMap model) {
        contactService.delete(contactService.read(contactId));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Contact> userContacts = contactService.getAllContacts(authentication.getName());
        model.addAttribute("contact", new Contact());
        model.addAttribute("modalDisplay", "none");
        model.addAttribute("contactList", userContacts);
        return "contacts";
    }

    @RequestMapping(name = "/contacts/update", method = RequestMethod.GET, params = {"contId"})
    public String updatePage(@RequestParam("contId") Long contactId, ModelMap model) {
        model.addAttribute("editContact", contactService.read(contactId));
        return "update";
    }

    @RequestMapping(name = "/contacts/successUpdate", method = RequestMethod.POST)
    public String updateContact(@Valid Contact editContact, BindingResult result, ModelMap model) {

        if (result.hasErrors()) return "update";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByLogin(authentication.getName());
        editContact.setUser(user);
        contactService.update(editContact);
        List<Contact> userContacts = contactService.getAllContacts(user.getLogin());
        model.addAttribute("contact", new Contact());
        model.addAttribute("contactList", userContacts);
        model.addAttribute("modalDisplay", "none");
        return "contacts";
    }


}
