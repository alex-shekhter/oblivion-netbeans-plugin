/*
 * Copyright (c) Fundacion Jala. All rights reserved.
 * Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */ 
package org.fundacionjala.oblivion.apex.grammar.ast.sosl;

import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.LiteralTree;

/**
 * Represents a tree node for a SOSL FIND clause. For example
 * <p>
 *    FIND 'mylogin@mycompany.com'
 * </p>
 * @author Pablo Romero
 */
public interface SOSLFindExpressionTree extends ExpressionTree {
    public LiteralTree getSearchQuery();
}
