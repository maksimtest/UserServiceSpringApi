package comparus.service.util;

import comparus.service.domain.User;
import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class UserComparator implements Comparator<User> {
    private String order;

    @Override
    public int compare(User o1, User o2) {
        int typeOfOrder = order.startsWith("-") ? -1 : 1;
        String field = order;
        if (field.startsWith("-")) {
            field = field.substring(1);
        }
        switch (field) {
            case "id":
                return typeOfOrder * o1.getId().compareTo(o2.getId());
            case "username":
                return typeOfOrder * o1.getUsername().compareTo(o2.getUsername());
            case "name":
                return typeOfOrder * o1.getName().compareTo(o2.getName());
            case "surname":
                return typeOfOrder * o1.getSurname().compareTo(o2.getSurname());
        }
        return 0;
    }
}
