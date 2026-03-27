import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import { AuthProvider } from './utils/AuthContext'
import { PrivateRoute } from './utils/PrivateRoute'
import { AuthPage } from './pages/AuthPage'
import { CatalogPage } from './pages/CatalogPage'
import { WorkoutDetailPage } from './pages/WorkoutDetailPage'
import './styles/globals.css'

function App() {
  return (
    <Router>
      <AuthProvider>
        <Routes>
          <Route path="/login" element={<AuthPage />} />
          <Route
            path="/workouts"
            element={
              <PrivateRoute>
                <CatalogPage />
              </PrivateRoute>
            }
          />
          <Route
            path="/workouts/:workoutId"
            element={
              <PrivateRoute>
                <WorkoutDetailPage />
              </PrivateRoute>
            }
          />
          <Route path="/" element={<Navigate to="/workouts" replace />} />
          <Route path="*" element={<Navigate to="/workouts" replace />} />
        </Routes>
      </AuthProvider>
    </Router>
  )
}

export default App
