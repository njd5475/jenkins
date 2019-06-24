/*
 * The MIT License
 *
 * Copyright (c) 2012, CloudBees, Intl., Nicolas De loof
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

package jenkins.management;

import org.jenkinsci.Symbol;

import com.dj.runner.locales.LocalizedString;

import hudson.Extension;
import hudson.model.ManagementLink;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
@Extension(ordinal = Integer.MAX_VALUE - 300) @Symbol("reload")
public class ReloadLink extends ManagementLink {

    @Override
    public String getIconFileName() {
        return "refresh.png";
    }

    public String getDisplayName() {
        return LocalizedString.ReloadLink_DisplayName.toString();
    }

    @Override
    public String getDescription() {
        return LocalizedString.ReloadLink_Description.toString();
    }

    @Override
    public String getUrlName() {
        return "reload";
    }

    @Override public boolean getRequiresConfirmation() {
        return true;
    }

    @Override
    public boolean getRequiresPOST() {
        return true;
    }
}
