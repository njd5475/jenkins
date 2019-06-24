/*
 * The MIT License
 *
 * Copyright 2015 Jesse Glick.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hudson.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.Issue;
import org.jvnet.hudson.test.JenkinsRule;

import com.dj.runner.locales.LocalizedString;

import hudson.FilePath;
import hudson.Launcher;
import hudson.slaves.WorkspaceList;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Notifier;

public class BuildExecutionTest {

    @Rule public JenkinsRule r = new JenkinsRule();

    @Issue("JENKINS-26698")
    @Test public void workspaceReliablyReleased() throws Exception {
        FreeStyleProject p = r.createFreeStyleProject();
        p.getPublishersList().add(new BrokenPublisher());
        FreeStyleBuild b = r.assertBuildStatus(Result.FAILURE, p.scheduleBuild2(0).get());
        r.assertLogContains(LocalizedString.Build_post_build_steps_failed.toLocale(), b);
        FilePath ws = r.jenkins.getWorkspaceFor(p);
        WorkspaceList.Lease lease = r.jenkins.toComputer().getWorkspaceList().allocate(ws);
        try {
            assertEquals(ws, lease.path);
        } finally {
            lease.close();
        }
    }

    @SuppressWarnings("unchecked") // not my fault
    private static class BrokenPublisher extends Notifier {
        @Override public boolean needsToRunAfterFinalized() {
            throw new IllegalStateException("oops");
        }
        @Override public boolean perform(AbstractBuild<?,?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
            return true;
        }
        @Override public BuildStepMonitor getRequiredMonitorService() {
            return BuildStepMonitor.NONE;
        }
    }

}
