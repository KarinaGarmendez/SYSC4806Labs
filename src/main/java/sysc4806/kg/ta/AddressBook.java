package sysc4806.kg.ta;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "book")
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // , mappedBy = "addressBook")
    @JoinColumn(name = "address_book_id")
    private List<BuddyInfo> addressBook;

    public AddressBook() {
        this.addressBook = new ArrayList<>();
    }

    public AddressBook(Collection<BuddyInfo> buddies) {
        this.addressBook = new ArrayList<>();
        addBuddies(buddies);
    }

    public void addBuddies(Collection<BuddyInfo> buddies) {
        this.addressBook.addAll(buddies);
    }

    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null) {
            this.addressBook.add(buddy);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSize() {
        return addressBook.size();
    }

    @Override
    public String toString() {
        if (getSize() > 0) {
            String addressBookString = "";
            for (BuddyInfo buddy : this.addressBook) {
                addressBookString = addressBookString.concat(buddy.toString() + "\n");
            }
            return addressBookString;
        } else {
            return null;
        }
    }
}
