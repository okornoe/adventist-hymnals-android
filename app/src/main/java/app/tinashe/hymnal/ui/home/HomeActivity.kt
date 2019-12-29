/*
 * Copyright (c) 2019. Tinashe Mzondiwa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package app.tinashe.hymnal.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.updatePadding
import app.tinashe.hymnal.R
import app.tinashe.hymnal.di.ViewModelFactory
import app.tinashe.hymnal.extensions.doOnApplyWindowInsets
import app.tinashe.hymnal.extensions.getViewModel
import app.tinashe.hymnal.ui.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_home)

        initUi()

        viewModel = getViewModel(this, viewModelFactory)

    }

    private fun initUi() {
        coordinator.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        bottomNav.doOnApplyWindowInsets { view, insets, padding ->
            view.updatePadding(bottom = padding.bottom + insets.systemWindowInsetBottom)
        }
    }

}