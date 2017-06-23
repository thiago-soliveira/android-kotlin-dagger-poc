package dagger.poc.android.injection

import dagger.Binds
import dagger.Module
import dagger.poc.android.common.LocalDatasource
import dagger.poc.android.common.RemoteDatasource

/**
 * Created by Thiago on 6/23/2017.
 */

@Module
internal abstract class DatasourceModule {

    @Binds
    @RemoteDatasource
    internal abstract fun staffRemoteDatasource(staffDatasource: StaffFakeDatasource):
            StaffDatasource

    @Binds
    @LocalDatasource
    internal abstract fun staffLocalDatasource(staffDatasource: StaffLocalDatasource):
            StaffDatasource

}