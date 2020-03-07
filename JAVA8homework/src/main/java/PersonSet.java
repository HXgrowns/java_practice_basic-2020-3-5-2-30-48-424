import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSet {
    private List<MasterNumber> masterNumbers;

    private List<Address> addresses;

    private List<Telephone> telephones;

    private List<Email> emails;

    public PersonSet(List<MasterNumber> masterNumbers,
                     List<Telephone> telephones,
                     List<Address> addresses,
                     List<Email> emails) {
        this.masterNumbers = masterNumbers;
        this.addresses = addresses;
        this.telephones = telephones;
        this.emails = emails;
    }

    public Stream<Person> groupToPeople() {
        // TODO: group the data to Stream<Person>
        // Can use Collectors.groupingBy method
        // Can add helper method
        List<Person> people = new ArrayList<>();
        if (masterNumbers.size() == 0) {
            return Stream.empty();
        }
        for (MasterNumber masterNumber : masterNumbers) {
            people.add(new Person(masterNumber.getNumber(), getPointTelephone(masterNumber), getPointAddress(masterNumber), getPointEmail(masterNumber)));
        }
        return people.stream();
    }

    public Address getPointAddress(MasterNumber masterNumber) {
        List<Address> filterAddress = Optional.of(addresses.stream().filter(address -> address.getMasterNumber().equals(masterNumber.getNumber())))
                .orElse(Stream.empty())
                .collect(Collectors.toList());
        if (filterAddress.isEmpty()) {
            return null;
        }
        return filterAddress.get(filterAddress.size() - 1);
    }

    public List<Telephone> getPointTelephone(MasterNumber masterNumber) {
        return Optional.of(telephones.stream().filter(telephone -> telephone.getMasterNumber().equals(masterNumber.getNumber())))
                .orElse(Stream.empty())
                .collect(Collectors.toList());
    }

    public List<Email> getPointEmail(MasterNumber masterNumber) {
        return Optional.of(emails.stream().filter(email -> email.getMasterNumber().equals(masterNumber.getNumber())))
                .orElse(Stream.empty())
                .collect(Collectors.toList());
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setMasterNumbers(List<MasterNumber> masterNumbers) {
        this.masterNumbers = masterNumbers;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }
}
