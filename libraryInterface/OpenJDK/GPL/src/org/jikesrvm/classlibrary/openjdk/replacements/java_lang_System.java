/*
 * Copyright (c) 1994, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.jikesrvm.classlibrary.openjdk.replacements;

import org.jikesrvm.VM;
import org.jikesrvm.classlibrary.JavaLangSupport;
import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;

@ReplaceClass(className = "java.lang.System")
public class java_lang_System {

  static {
    VM.sysWriteln("Static init called");
  }

  @ReplaceMember
  public static void registerNatives() {
    VM.sysWriteln("registerNativesCalled");
    // no natives
  }

  @ReplaceMember
  public static void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length) {
    JavaLangSupport.arraycopy(src, srcPos, dest, destPos, length);
  }

  @ReplaceMember
  public static int identityHashCode(Object obj) {
    return JavaLangSupport.identityHashCode(obj);
  }

  @ReplaceMember
  public static String mapLibraryName(String libname) {
    return JavaLangSupport.mapLibraryName(libname);
  }

}
