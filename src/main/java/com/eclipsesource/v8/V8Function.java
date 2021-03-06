/*******************************************************************************
 * Copyright (c) 2015 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.v8;

public class V8Function extends V8Object {

    protected V8Function(final V8 v8) {
        super(v8);
    }

    protected V8Function(final V8 v8, final int objectHandle) {
        super(v8, objectHandle);
    }

    @Override
    protected V8Value createTwin(final int newHandle) {
        return new V8Function(v8, newHandle);
    }

    @Override
    public V8Function twin() {
        return (V8Function) super.twin();
    }

    public Object call(final V8Object receiver, final V8Array parameters) {
        v8.checkThread();
        checkReleaesd();
        int parametersHandle = parameters == null ? -1 : parameters.getHandle();
        return v8.executeFunction(v8.getV8RuntimePtr(), receiver.objectHandle, objectHandle, parametersHandle);
    }
}
