/*
 * The MIT License
 * 
 * Copyright (c) 2004-2010, Sun Microsystems, Inc., Kohsuke Kawaguchi, Stephen Connolly
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

import java.util.Collection;

import hudson.Extension;
import hudson.ExtensionList;
import hudson.ExtensionPoint;
import hudson.model.labels.LabelAtom;

/**
 * Automatically adds labels to {@link Node}s.
 *
 * <p>
 * To register your implementation, put {@link Extension} on your derived types.
 *
 * @author Stephen Connolly
 * @since 1.323
 *      Signature of this class changed in 1.323, after making sure that no
 *      plugin in the Subversion repository is using this.
 */
public abstract class LabelFinder implements ExtensionPoint {
    /**
     * Returns all the registered {@link LabelFinder}s.
     */
    public static ExtensionList<LabelFinder> all() {
        return ExtensionList.lookup(LabelFinder.class);
    }

    /**
     * Find the labels that the node supports.
     *
     * @param node
     *      The node that receives labels. Never null.
     * @return
     *      A set of labels for the node. Can be empty but never null.
     */
    public abstract Collection<LabelAtom> findLabels(Node node);
}
