import React from 'react';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import CircularProgress from '@mui/material/CircularProgress';
import MovieCard from './MovieCard';

export default function ResultList({ results, loading, error }) {
  if (loading) {
    return (
      <Grid container justifyContent="center" sx={{ mt: 4 }}>
        <CircularProgress aria-label="loading" />
      </Grid>
    );
  }

  if (error) {
    return (
      <Typography color="error" sx={{ mt: 2 }} role="alert">
        {error}
      </Typography>
    );
  }

  if (!results.length) {
    return (
      <Typography variant="h6" sx={{ mt: 2 }}>
        No movies found.
      </Typography>
    );
  }

  return (
    <Grid container spacing={2} aria-label="search results">
      {results.map((movie) => (
        <Grid item key={movie.id} xs={12} sm={6} md={4}>
          <MovieCard movie={movie} />
        </Grid>
      ))}
    </Grid>
  );
}
