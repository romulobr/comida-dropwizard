package co.romulo.comida.persistence;

import co.romulo.comida.group.Group;
import co.romulo.comida.group.GroupDao;
import co.romulo.comida.persistence.base.PersistenceTest;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GroupPersistenceTest extends PersistenceTest {

    GroupDao dao;

    @Override
    protected void setUpDataAccessObjects() {
        dao = dbi.onDemand(GroupDao.class);
    }

    @Test
    public void findsGroupsByUser() throws Exception {
        List<Group> groupsOwnedByUser = dao.findGroupsOwnedByUserWithId(1L);

        assertThat(groupsOwnedByUser.get(0).getName(), is("group 1"));
        assertThat(groupsOwnedByUser.get(1).getName(), is("group 2"));
        assertThat(groupsOwnedByUser.get(2).getName(), is("group 3"));
    }

    @Test
    public void findsIdInGroupOrNothing() throws Exception {
        assertThat(dao.findUserIdInGroupOrNothing(1L, 1L), is(not(nullValue())));
        assertThat(dao.findUserIdInGroupOrNothing(2L, 1L), is(not(nullValue())));
        assertThat(dao.findUserIdInGroupOrNothing(3L, 1L), is(not(nullValue())));
        assertThat(dao.findUserIdInGroupOrNothing(4L, 1L), is(nullValue()));
    }
}
