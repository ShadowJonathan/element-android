/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotredesign.core.di

import android.content.Context
import android.content.res.Resources
import dagger.BindsInstance
import dagger.Component
import im.vector.matrix.android.api.Matrix
import im.vector.matrix.android.api.auth.Authenticator
import im.vector.matrix.android.api.session.Session
import im.vector.riotredesign.EmojiCompatFontProvider
import im.vector.riotredesign.VectorApplication
import im.vector.riotredesign.core.pushers.PushersManager
import im.vector.riotredesign.features.configuration.VectorConfiguration
import im.vector.riotredesign.features.crypto.keysrequest.KeyRequestHandler
import im.vector.riotredesign.features.crypto.verification.IncomingVerificationRequestHandler
import im.vector.riotredesign.features.home.AvatarRenderer
import im.vector.riotredesign.features.home.HomeNavigator
import im.vector.riotredesign.features.home.HomeRoomListObservableStore
import im.vector.riotredesign.features.home.group.SelectedGroupStore
import im.vector.riotredesign.features.navigation.Navigator
import im.vector.riotredesign.features.notifications.NotifiableEventResolver
import im.vector.riotredesign.features.notifications.NotificationBroadcastReceiver
import im.vector.riotredesign.features.notifications.NotificationDrawerManager
import im.vector.riotredesign.features.notifications.PushRuleTriggerListener
import im.vector.riotredesign.features.rageshake.BugReporter
import im.vector.riotredesign.features.rageshake.VectorUncaughtExceptionHandler
import javax.inject.Singleton

@Component(modules = [VectorModule::class])
@Singleton
interface VectorComponent {

    fun inject(vectorApplication: NotificationBroadcastReceiver)

    fun inject(vectorApplication: VectorApplication)

    fun matrix(): Matrix

    fun currentSession(): Session

    fun notificationDrawerManager(): NotificationDrawerManager

    fun appContext(): Context

    fun resources(): Resources

    fun vectorConfiguration(): VectorConfiguration

    fun avatarRenderer(): AvatarRenderer

    fun activeSessionHolder(): ActiveSessionHolder

    fun emojiCompatFontProvider(): EmojiCompatFontProvider

    fun navigator(): Navigator

    fun homeNavigator(): HomeNavigator

    fun homeRoomListObservableStore(): HomeRoomListObservableStore

    fun selectedGroupStore(): SelectedGroupStore

    fun incomingVerificationRequestHandler(): IncomingVerificationRequestHandler

    fun incomingKeyRequestHandler(): KeyRequestHandler

    fun authenticator(): Authenticator

    fun bugReporter(): BugReporter

    fun vectorUncaughtExceptionHandler(): VectorUncaughtExceptionHandler

    fun pushRuleTriggerListener(): PushRuleTriggerListener

    fun pusherManager(): PushersManager

    fun notifiableEventResolver(): NotifiableEventResolver

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): VectorComponent
    }

}