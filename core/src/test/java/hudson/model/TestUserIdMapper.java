package hudson.model;

import java.io.File;
import java.io.IOException;

import jenkins.model.IdStrategy;

class TestUserIdMapper extends UserIdMapper {

    private File usersDirectory;
    private IdStrategy idStrategy;

    TestUserIdMapper(File usersDirectory, IdStrategy idStrategy) throws IOException {
        this.usersDirectory = usersDirectory;
        this.idStrategy = idStrategy;
    }

    @Override
    protected File getUsersDirectory() {
        return usersDirectory;
    }

    @Override
    protected IdStrategy getIdStrategy() {
        return idStrategy;
    }
}
