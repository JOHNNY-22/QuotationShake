package dadm.juaalgo7.quotationshake.di

import dadm.juaalgo7.quotationshake.data.settings.SettingsDataSource
import dadm.juaalgo7.quotationshake.data.settings.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBinderModule {
    @Binds
    abstract fun bindSettingsDataSource(settingsDS: SettingsDataSource): SettingsDataSource
    @Binds
    abstract fun bindSettingsDataRepository(settingsRepository: SettingsRepository): SettingsRepository
}