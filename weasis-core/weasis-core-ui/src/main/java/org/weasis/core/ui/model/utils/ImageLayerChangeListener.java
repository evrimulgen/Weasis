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
package org.weasis.core.ui.model.utils;

import org.weasis.core.api.image.util.ImageLayer;
import org.weasis.core.api.media.data.ImageElement;

@FunctionalInterface
public interface ImageLayerChangeListener<E extends ImageElement> {

    void handleLayerChanged(ImageLayer<E> layer);
}
