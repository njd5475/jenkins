package jenkins.security.s2m;

import java.io.IOException;

import javax.inject.Inject;

import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.HttpResponses;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.interceptor.RequirePOST;

import hudson.Extension;
import hudson.LocalizedString;
import hudson.model.AdministrativeMonitor;

/**
 * If {@link AdminWhitelistRule#masterKillSwitch} is on, warn the user.
 *
 * @author Kohsuke Kawaguchi
 * @since 1.587 / 1.580.1
 */
@Extension
public class MasterKillSwitchWarning extends AdministrativeMonitor {
    @Inject
    AdminWhitelistRule rule;

    @Inject
    MasterKillSwitchConfiguration config;

    @Override
    public boolean isActivated() {
        return rule.getMasterKillSwitch() && config.isRelevant();
    }

    @Override
    public String getDisplayName() {
        return LocalizedString.MasterKillSwitchWarning_DisplayName.toString();
    }

    @RequirePOST
    public HttpResponse doAct(@QueryParameter String dismiss) throws IOException {
        if(dismiss!=null) {
            disable(true);
            return HttpResponses.redirectViaContextPath("/manage");
        } else {
            return HttpResponses.redirectViaContextPath("configureSecurity");
        }
    }
}
