/*******************************************************************************
 * Copyright (c) 2016 Weasis Team and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Roduit - initial API and implementation
 *******************************************************************************/
package org.weasis.acquire.explorer.gui.central.meta.model.imp;

import java.util.Optional;

import org.dcm4che3.data.Tag;
import org.weasis.acquire.explorer.AcquireManager;
import org.weasis.acquire.explorer.gui.central.meta.model.AcquireMetadataTableModel;
import org.weasis.core.api.media.data.TagW;
import org.weasis.dicom.codec.TagD;

public class AcquireGlobalMeta extends AcquireMetadataTableModel {
    private static final long serialVersionUID = 8912202268139591519L;

    private static final AcquireGlobalMeta instance = new AcquireGlobalMeta();

    private static final TagW[] TAGS_TO_DISPLAY = TagD.getTagFromIDs(Tag.PatientID, Tag.PatientName,
        Tag.PatientBirthDate, Tag.PatientSex, Tag.AccessionNumber, Tag.StudyID, Tag.StudyDescription);

    private static final TagW[] TAGS_EDITABLE = TagD.getTagFromIDs(Tag.StudyDescription);

    private static final TagW[] TAGS_TO_PUBLISH = TagD.getTagFromIDs(Tag.PatientID, Tag.PatientName,
        Tag.PatientBirthDate, Tag.PatientSex, Tag.AccessionNumber, Tag.StudyID, Tag.StudyDescription);

    private AcquireGlobalMeta() {
        super(AcquireManager.GLOBAL);
    }

    public static AcquireGlobalMeta getInstance() {
        return instance;
    }

    @Override
    protected Optional<TagW[]> tagsToDisplay() {
        return Optional.of(TAGS_TO_DISPLAY);
    }

    @Override
    protected Optional<TagW[]> tagsEditable() {
        return AcquireManager.GLOBAL.isAllowFullEdition() ? Optional.of(TAGS_TO_DISPLAY) : Optional.of(TAGS_EDITABLE);
    }

    @Override
    protected Optional<TagW[]> tagsToPublish() {
        return Optional.of(TAGS_TO_PUBLISH);
    }
}
