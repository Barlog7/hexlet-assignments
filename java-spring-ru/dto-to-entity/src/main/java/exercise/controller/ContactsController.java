package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO createDTO) {
        var contact = toEntity(createDTO);
        contactRepository.save(contact);
        return toContactDTO(contact);
    }

    private Contact toEntity(ContactCreateDTO createDTO) {
        var contact = new Contact();
        contact.setFirstName(createDTO.getFirstName());
        contact.setLastName(createDTO.getLastName());
        contact.setPhone(contact.getPhone());
        return contact;
    }
    private ContactDTO toContactDTO(Contact contact) {
        var contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setLastName(contact.getLastName());
        contactDTO.setFirstName(contact.getFirstName());
        contactDTO.setUpdatedAt(contact.getUpdatedAt());
        contactDTO.setCreatedAt(contact.getCreatedAt());
        return contactDTO;
    }
    // END
}
