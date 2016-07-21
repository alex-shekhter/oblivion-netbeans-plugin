/*
 * Copyright (c) Fundacion Jala. All rights reserved.
 * Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */ 
package org.fundacionjala.oblivion.apex.grammar.parser.exceptions;

import org.fundacionjala.oblivion.apex.grammar.jcclexer.ParseException;

/**
 * Represents an exception when a do-while statement is not well specified.
 *
 * @author Maria Garcia
 */
public class IllegalDoWhileStatementException extends ContextParseException{

    private static final String WHILE = "while";

    public IllegalDoWhileStatementException(ParseException originalError) {
        super(originalError);
    }

    @Override
    protected void init() {
        String key = null;
        currentToken = originalToken.next;

        if (originalToken.image.equals(RIGHT_BRACE) && !currentToken.image.equalsIgnoreCase(WHILE)) {
            key = "grammar.error.statement.dowhile.do";
        } else if ((originalToken.image.equalsIgnoreCase(WHILE) && !currentToken.image.equals(LEFT_PARENTHESIS))
                    || originalToken.image.equals(LEFT_PARENTHESIS)) {
            key = "grammar.error.statement.dowhile.while";
        } else if (originalToken.image.equals(RIGHT_PARENTHESIS)) {
            key = "grammar.error.separator.semicolon";
        } else if (!currentToken.image.equals(RIGHT_PARENTHESIS)) {
            key = "grammar.error.operator.parenthesis.right";
        } else {
            key = "grammar.error.unexpected";
        }

        message = String.format(bundle.getString(key), currentToken.image, currentToken.beginLine, currentToken.beginColumn);
    }
}
