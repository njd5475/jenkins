package jenkins.diagnostics;

import static hudson.Util.fixEmpty;

import java.io.IOException;

import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.StaplerRequest;

import com.dj.runner.locales.LocalizedString;

import hudson.Extension;
import hudson.model.AdministrativeMonitor;
import hudson.util.FormValidation;
import jenkins.model.Jenkins;

@Restricted(NoExternalUse.class)
@Extension
public class URICheckEncodingMonitor extends AdministrativeMonitor {

    public boolean isCheckEnabled() {
        return !"ISO-8859-1".equalsIgnoreCase(System.getProperty("file.encoding"));
    }

    @Override
    public boolean isActivated() {
        return true;
    }

    @Override
    public String getDisplayName() {
        return LocalizedString.URICheckEncodingMonitor_DisplayName.toString();
    }

    public FormValidation doCheckURIEncoding(StaplerRequest request) throws IOException {
        Jenkins.getInstance().checkPermission(Jenkins.ADMINISTER);
        // expected is non-ASCII String
        final String expected = "\u57f7\u4e8b";
        final String value = fixEmpty(request.getParameter("value"));
        if (!expected.equals(value))
            return FormValidation.warningWithMarkup(LocalizedString.Hudson_NotUsesUTF8ToDecodeURL.toLocale());
        return FormValidation.ok();
    }
}
