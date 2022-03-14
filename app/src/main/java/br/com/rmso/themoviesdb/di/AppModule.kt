package br.com.rmso.themoviesdb.di
import br.com.rmso.themoviesdb.data.datasource.remote.MovieRemoteDataSourceImpl
import br.com.rmso.themoviesdb.data.repository.MovieRepositoryImpl
import br.com.rmso.themoviesdb.data.retrofit.ServiceProvider
import br.com.rmso.themoviesdb.domain.repository.MovieRepository
import br.com.rmso.themoviesdb.domain.usecase.GetMovieUseCase
import br.com.rmso.themoviesdb.presentation.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModules = module {
    single<ServiceProvider> {
        ServiceProvider()
    }
}

val dataModules = module {
    factory <MovieRepository>{
        MovieRepositoryImpl(
            remoteDataSource = MovieRemoteDataSourceImpl(
                serviceProvider = get()
            )
        )
    }
}

val domainModules = module {
    factory { GetMovieUseCase(repository = get()) }
}

val presentationModules = module {
    viewModel {
        MovieViewModel(
            getMovieUseCase = get()
        )
    }
}

