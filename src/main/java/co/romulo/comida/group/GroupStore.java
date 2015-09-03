package co.romulo.comida.group;

import co.romulo.comida.user.User;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GroupStore {

    GroupDao dao;

    public List<Group> groupsWithUser(User user) {
        return dao.findGroupsOwnedByUserWithId(user.getId());
    }

    public boolean isUserInGroup(User user, Long groupId) {
        return dao.findUserIdInGroupOrNothing(user.getId(), groupId) != null;
    }
}
