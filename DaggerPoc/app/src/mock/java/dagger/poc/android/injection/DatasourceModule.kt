package dagger.poc.android.injection

import dagger.Binds
import dagger.Module
import dagger.poc.android.data.SomeDataSource
import dagger.poc.android.data.SomeLocalDataSource

/**
 * Created by Thiago on 6/23/2017.
 */

@Module
internal abstract class DataSourceModule {

    @Binds
    @RemoteQualifier
    internal abstract fun someRemoteDataSource(someDataSource: SomeFakeDataSource):
            SomeDataSource

    @Binds
    @LocalQualifier
    internal abstract fun someLocalDataSource(someLocalDataSource: SomeLocalDataSource):
            SomeDataSource

}