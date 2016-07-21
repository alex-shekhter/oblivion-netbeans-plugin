/*
 * Copyright (c) Fundacion Jala. All rights reserved.
 * Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */ 
package org.fundacionjala.oblivion.salesforce.filetype.iterator;

import org.fundacionjala.oblivion.salesforce.filetype.iterator.Bundle;
import org.fundacionjala.oblivion.salesforce.filetype.wizard.AbstractSalesforceFileTypeWizardIterator;
import org.fundacionjala.oblivion.salesforce.filetype.wizard.SalesforceVisualPanel;
import org.netbeans.api.templates.TemplateRegistration;
import org.openide.util.NbBundle.Messages;

/**
 * Iterator for .page salesforce extension
 *
 * @author Sergio Daza
 */
@TemplateRegistration(folder = "Salesforce",
    displayName = "#PageWizardIterator_displayName",
    description = "../resource/Page.html",
    content = "../template/template.page",
    scriptEngine = "freemarker",
    position = 109)
@Messages({"PageWizardIterator_displayName=Visualforce Page", "PageWizardIterator_caption=Create New Visualforce Page"})
public final class PageWizardIterator extends AbstractSalesforceFileTypeWizardIterator {

    private static final String METADATA_NAME = "Page";
    private static final String METADATA_FILE_NAME = ".page-meta.xml";
    private static final String DESTINATION_FOLDER = "src/pages";
    private static final String TITLE_PANEL = Bundle.PageWizardIterator_caption();
    private static final boolean SHOW_VERSION = true;

    @Override
    public String getName() {
        return TITLE_PANEL;
    }

    @Override
    protected String getMetadataFileName() {
        String metadataFileName = (String) wizard.getProperty(SalesforceVisualPanel.FILE_NAME);
        return metadataFileName + METADATA_FILE_NAME;
    }

    @Override
    protected String getMetadataName() {
        return METADATA_NAME;
    }

    @Override
    protected String getDestinationFolder() {
        return DESTINATION_FOLDER;
    }

    @Override
    protected Boolean getWithMetadataFile() {
        return SHOW_VERSION;
    }

}
