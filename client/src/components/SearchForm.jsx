import React, { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import Button from '@mui/material/Button';
import Grid from '@mui/material/Grid';

const languages = ['English', 'Hindi', 'Tamil'];

const escapeInput = (value) => value.replace(/[<>]/g, '');

export default function SearchForm({ onSearch, loading }) {
  const [city, setCity] = useState('');
  const [cities, setCities] = useState([]);
  const [loadingCities, setLoadingCities] = useState(true);
  const [cityError, setCityError] = useState('');
  const [language, setLanguage] = useState('');
  const [date, setDate] = useState('');

  useEffect(() => {
    async function fetchCities() {
      try {
        const res = await fetch('/api/v1/cities');
        if (!res.ok) throw new Error('Network response was not ok');
        const data = await res.json();
        setCities(Array.isArray(data) ? data : []);
      } catch (err) {
        console.error(err);
        setCityError('Unable to load cities');
      } finally {
        setLoadingCities(false);
      }
    }
    fetchCities();
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    onSearch({
      city: escapeInput(city),
      language: escapeInput(language),
      date
    });
  };

  return (
    <Box component="form" onSubmit={handleSubmit} sx={{ mb: 3 }}>
      <Grid container spacing={2}>
        <Grid item xs={12} sm={4}>
          <TextField
            select
            label="City"
            fullWidth
            value={city}
            onChange={(e) => setCity(e.target.value)}
            required
            aria-label="Select city"
            disabled={loadingCities || !!cityError}
          >
            {loadingCities && (
              <MenuItem disabled>Loading...</MenuItem>
            )}
            {cityError && !loadingCities && (
              <MenuItem disabled>Error loading cities</MenuItem>
            )}
            {!loadingCities && !cityError &&
              cities.map((c) => (
                <MenuItem key={c} value={c}>
                  {c}
                </MenuItem>
              ))}
          </TextField>
        </Grid>
        <Grid item xs={12} sm={4}>
          <TextField
            select
            label="Language"
            fullWidth
            value={language}
            onChange={(e) => setLanguage(e.target.value)}
            required
            aria-label="Select language"
          >
            {languages.map((l) => (
              <MenuItem key={l} value={l}>
                {l}
              </MenuItem>
            ))}
          </TextField>
        </Grid>
        <Grid item xs={12} sm={3}>
          <TextField
            label="Date"
            type="date"
            fullWidth
            InputLabelProps={{ shrink: true }}
            value={date}
            onChange={(e) => setDate(e.target.value)}
            required
            aria-label="Select date"
          />
        </Grid>
        <Grid item xs={12} sm={1} sx={{ display: 'flex', alignItems: 'center' }}>
          <Button
            type="submit"
            variant="contained"
            color="secondary"
            disabled={loading}
            fullWidth
          >
            Search
          </Button>
        </Grid>
      </Grid>
    </Box>
  );
}
