package jenkins.model;

import java.io.IOException;

import org.jenkinsci.Symbol;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.slaves.NodeProperty;
import hudson.slaves.NodePropertyDescriptor;
import net.sf.json.JSONObject;

/**
 * Include {@link NodePropertyDescriptor} configurations.
 *
 * @author Kohsuke Kawaguchi
 */
@Extension(ordinal=110) @Symbol("nodeProperties") // historically this was placed above GlobalPluginConfiguration
public class GlobalNodePropertiesConfiguration extends GlobalConfiguration {
    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        try {
            Jenkins j = Jenkins.get();
            JSONObject np = json.getJSONObject("globalNodeProperties");
            if (!np.isNullObject()) {
                j.getGlobalNodeProperties().rebuild(req, np, NodeProperty.for_(j));
            }
            return true;
        } catch (IOException e) {
            throw new FormException(e,"globalNodeProperties");
        }
    }
}
