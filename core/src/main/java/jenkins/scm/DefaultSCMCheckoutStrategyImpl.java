package jenkins.scm;

import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.model.AbstractProject;

/**
 * Default {@link SCMCheckoutStrategy} implementation.
 */
public class DefaultSCMCheckoutStrategyImpl extends SCMCheckoutStrategy {

    @DataBoundConstructor
    public DefaultSCMCheckoutStrategyImpl() {}

    @Extension @Symbol("standard")
    public static class DescriptorImpl extends SCMCheckoutStrategyDescriptor {
        @Override
        public String getDisplayName() {
            return "Default";
        }

        @Override
        public boolean isApplicable(AbstractProject project) {
            return true;
        }
    }
}
