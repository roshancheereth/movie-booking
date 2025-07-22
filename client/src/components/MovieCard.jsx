import React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

export default function MovieCard({ movie }) {
  return (
    <Card sx={{ height: '100%' }} aria-label={`Movie ${movie.title}`}>
      <CardContent>
        <Typography variant="h6" component="div" gutterBottom>
          {movie.title}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {movie.language} | {movie.city}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {new Date(movie.showTime).toLocaleString()}
        </Typography>
      </CardContent>
    </Card>
  );
}
