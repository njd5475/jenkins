package jenkins.security.s2m;

import java.util.regex.Pattern;

import hudson.FilePath;

/**
 * One entry of the {@link FilePath} access rule.
 *
 * @author Kohsuke Kawaguchi
 */
class FilePathRule {
    final Pattern path;
    final OpMatcher op;
    final boolean allow;

    FilePathRule(Pattern path, OpMatcher op, boolean allow) {
        this.path = path;
        this.op = op;
        this.allow = allow;
    }
}
