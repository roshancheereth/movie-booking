import React, { useState } from 'react';
import Container from '@mui/material/Container';
import CssBaseline from '@mui/material/CssBaseline';
import Header from './components/Header';
import Footer from './components/Footer';
import SearchForm from './components/SearchForm';
import ResultList from './components/ResultList';

export default function App() {
  const [results, setResults] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const handleSearch = async (criteria) => {
    setLoading(true);
    setError('');
    try {
      const params = new URLSearchParams(criteria);
      const response = await fetch(`/api/v1/search?${params.toString()}`);
      if (!response.ok) throw new Error('Network response was not ok');
      const data = await response.json();
      setResults(Array.isArray(data) ? data : []);
    } catch (err) {
      console.error(err);
      // fallback dummy data
      setResults([
        {
          id: 1,
          title: 'Sample Movie',
          language: criteria.language,
          city: criteria.city,
          showTime: criteria.date + 'T19:30:00'
        }
      ]);
      setError('Unable to fetch results, showing sample data.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <React.Fragment>
      <CssBaseline />
      <Header />
      <Container sx={{ py: 4 }}>
        <SearchForm onSearch={handleSearch} loading={loading} />
        <ResultList results={results} loading={loading} error={error} />
      </Container>
      <Footer />
    </React.Fragment>
  );
}
