package hudson;

import java.net.URL;

import org.jenkinsci.Symbol;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import hudson.model.ManagementLink;

/**
 * Show "About Jenkins" link.
 * 
 * @author Kohsuke Kawaguchi
 */
@Extension @Symbol("about")
public class AboutJenkins extends ManagementLink {
    @Override
    public String getIconFileName() {
        return "help.png";
    }

    @Override
    public String getUrlName() {
        return "about";
    }

    public String getDisplayName() {
        return LocalizedString.AboutJenkins_DisplayName.toLocale();
    }

    @Override
    public String getDescription() {
        return LocalizedString.AboutJenkins_Description.toLocale();
    }

    @Restricted(NoExternalUse.class)
    public URL getLicensesURL() {
        return AboutJenkins.class.getResource("/META-INF/licenses.xml");
    }

}
