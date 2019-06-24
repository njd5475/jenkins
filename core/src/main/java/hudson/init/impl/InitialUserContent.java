/*
 * The MIT License
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc.
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
package hudson.init.impl;

import static hudson.init.InitMilestone.JOB_LOADED;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dj.runner.locales.LocalizedString;

import hudson.init.Initializer;
import jenkins.model.Jenkins;

/**
 * Prepares userContent folder and put a readme if it doesn't exist.
 * @author Kohsuke Kawaguchi
 */
public class InitialUserContent {
    @Initializer(after=JOB_LOADED)
    public static void init(Jenkins h) throws IOException {
        File userContentDir = new File(h.getRootDir(), "userContent");
        if(!userContentDir.exists()) {
            userContentDir.mkdirs();
            FileUtils.writeStringToFile(new File(userContentDir,"readme.txt"), LocalizedString.Hudson_USER_CONTENT_README + "\n");
        }
    }
}
