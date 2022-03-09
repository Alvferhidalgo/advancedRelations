package com.example.advancedRelations;

import com.example.advancedRelations.entities.*;
import com.example.advancedRelations.repositories.*;
import com.example.advancedRelations.service.AccountSpecService;
import com.example.advancedRelations.service.BenefitSpecService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EntityGraphTest {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OfficeRepository officeRepository;

    @Autowired
    BenefitRepository benefitRepository;

    @Autowired
    AccountSpecService accountService;

    @Autowired
    BenefitSpecService benefitService;

    @BeforeEach
    void setUp() {

        customerRepository.deleteAll();
        addressRepository.deleteAll();
        accountRepository.deleteAll();
        officeRepository.deleteAll();

        Address address1 = new Address(null, "Calle falsa", 123, "Springfield");
        Address address2 = new Address(null, "Calle auténtica", 321, "Shelbyville");
        Address address3 = new Address(null, "Calle falsa", 222, "Springfield");
        Address address4 = new Address(null, "Calle falsa", 333, "Springfield");
        Address address5 = new Address(null, "Calle falsa", 444, "Springfield");
        Address address6 = new Address(null, "Calle banco", 1, "Atlantis");
        Address address7 = new Address(null, "Calle otro banco", 2, "Pandora");
        addressRepository.saveAll(List.of(address1, address2, address3, address4, address5, address6, address7));

        Account account1 = new Account(null, 1234567890L, 100D);
        Account account2 = new Account(null, 9876543210L, 500D);
        Account account3 = new Account(null, 5555555555L, 600D);
        Account account4 = new Account(null, 6666666666L, 700D);
        Account account5 = new Account(null, 7777777777L, 800D);
        Account account6 = new Account(null, 8888888888L, 900D);
        accountRepository.saveAll(List.of(account1, account2, account3, account4, account5, account6));

        List<Account> accounts1 = List.of(account1, account2);
        List<Account> accounts2 = List.of(account3);
        List<Account> accounts3 = List.of(account4);
        List<Account> accounts4 = List.of(account5);
        List<Account> accounts5 = List.of(account6);

        Customer customer1 = new Customer(null, "Arnold Schwarzenegger", "1111111B", address1, accounts1);
        Customer customer2 = new Customer(null, "Bruce Willis", "22222222BW", address2, accounts2);
        Customer customer3 = new Customer(null, "Jean Claude Van-Damme", "3333333J", address3, accounts3);
        Customer customer4 = new Customer(null, "Jason Momoa", "4444444M", address4, accounts4);
        Customer customer5 = new Customer(null, "Sylvester Stallone", "asddfg33", address5, accounts5);
        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5));

        List<Customer> customers1 = List.of(customer1, customer2, customer3);
        List<Customer> customers2 = List.of(customer4, customer5);

        Office office1 = new Office(null, "0118999-3", address6, customers1);
        Office office2 = new Office(null, "222222-2", address7, customers2);

        officeRepository.saveAll(List.of(office1, office2));

        Benefit benefit1 = new Benefit(null, "Smith", 100D, true);
        Benefit benefit2 = new Benefit(null, "Elrond", 200D, true);
        Benefit benefit3 = new Benefit(null, "W", 300D, false);
        Benefit benefit4 = new Benefit(null, "K", 400D, false);

        benefitRepository.saveAll(List.of(benefit1, benefit2, benefit3, benefit4));
    }

    @Transactional
    @Test
    void name() {
        Optional<Customer> customerOptional = customerRepository.findById(1L);
        assertTrue(customerOptional.isPresent());
    }

    @Transactional
    @Test
    void findByIdWithCategoriesJQPL() {
        Customer customer = customerRepository.findByIdWithAddressJQPL(1L);
        System.out.println(customer.getAddress());
    }

}
