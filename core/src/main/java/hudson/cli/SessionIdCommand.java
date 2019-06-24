package hudson.cli;

import com.dj.runner.locales.LocalizedString;

import hudson.Extension;
import jenkins.model.Jenkins;

/**
 * Prints the current session ID number (that changes for every run)
 * to allow clients to reliably wait for a restart.
 *
 * @author Kohsuke Kawaguchi
 */
@Extension
public class SessionIdCommand extends CLICommand {
    @Override
    public String getShortDescription() {
        return LocalizedString.SessionIdCommand_ShortDescription.toString();
    }

    protected int run() {
        stdout.println(Jenkins.SESSION_HASH);
        return 0;
    }
}

