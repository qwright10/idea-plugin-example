/*
 * Copyright 2019 Nazmul Idris. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package actions

import TestUtils.Companion.computeBasePath
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File

class SearchOnStackOverflowActionTest : BasePlatformTestCase() {

  private lateinit var testFolderLocation: String

  @Before
  public override fun setUp() {
    super.setUp()
    testFolderLocation = computeBasePath()
    assertThat(testFolderLocation).isNotNull()
  }

  @Test
  fun testSelectedTextIsSearchedOnStackOverflow() {
    // Load test file w/ text selected.
    myFixture.configureByFile(
        testFolderLocation + File.separator + "testFile.md")
    // Try and perform the action.
    val action = SearchOnStackOverflowAction()
    val presentation = myFixture.testAction(action)
    assertThat(presentation.isEnabledAndVisible).isTrue()
  }
}