import { useState, useEffect, useCallback } from 'react'
import { useNavigate } from 'react-router-dom'
import { workoutService } from '../services/workoutService'
import { useAuth } from '../utils/useAuth'
import '../styles/Catalog.css'

export function CatalogPage() {
  const [workouts, setWorkouts] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')
  const [search, setSearch] = useState('')
  const [category, setCategory] = useState('')
  const [page, setPage] = useState(0)
  const [totalPages, setTotalPages] = useState(0)

  const { logout } = useAuth()
  const navigate = useNavigate()

  const fetchWorkouts = useCallback(async () => {
    try {
      setLoading(true)
      setError('')
      const data = await workoutService.getWorkouts(page, 10, search, category)
      setWorkouts(data.content || [])
      setTotalPages(data.totalPages || 0)
    } catch (err) {
      setError('Failed to load workouts')
      console.error(err)
    } finally {
      setLoading(false)
    }
  }, [page, search, category])

  useEffect(() => {
    fetchWorkouts()
  }, [fetchWorkouts])

  const handleLogout = () => {
    logout()
    navigate('/login')
  }

  const handleWorkoutClick = (workoutId) => {
    navigate(`/workouts/${workoutId}`)
  }

  return (
    <div className="catalog-container">
      <header className="catalog-header">
        <div className="header-content">
          <h1>DS Gym House</h1>
          <button onClick={handleLogout} className="btn-logout">
            Logout
          </button>
        </div>
      </header>

      <div className="catalog-filters">
        <input
          type="text"
          placeholder="Search workouts..."
          value={search}
          onChange={(e) => {
            setSearch(e.target.value)
            setPage(0)
          }}
          className="filter-input"
        />

        <select
          value={category}
          onChange={(e) => {
            setCategory(e.target.value)
            setPage(0)
          }}
          className="filter-select"
        >
          <option value="">All Categories</option>
          <option value="strength">Strength</option>
          <option value="cardio">Cardio</option>
          <option value="flexibility">Flexibility</option>
        </select>
      </div>

      {error && <div className="error-message">{error}</div>}

      {loading ? (
        <div className="loading-message">Loading workouts...</div>
      ) : workouts.length === 0 ? (
        <div className="empty-message">No workouts found</div>
      ) : (
        <>
          <div className="workouts-grid">
            {workouts.map((workout) => (
              <div
                key={workout.id}
                className="workout-card"
                onClick={() => handleWorkoutClick(workout.id)}
              >
                <div className="workout-card-header">
                  <h3>{workout.name}</h3>
                  <span className="workout-category">{workout.category}</span>
                </div>
                <p className="workout-description">{workout.description}</p>
                <div className="workout-info">
                  <span>📊 {workout.difficulty}</span>
                  <span>⏱️ {workout.durationMinutes} min</span>
                </div>
              </div>
            ))}
          </div>

          {totalPages > 1 && (
            <div className="pagination">
              <button
                onClick={() => setPage(Math.max(0, page - 1))}
                disabled={page === 0}
              >
                Previous
              </button>
              <span>
                Page {page + 1} of {totalPages}
              </span>
              <button
                onClick={() => setPage(Math.min(totalPages - 1, page + 1))}
                disabled={page >= totalPages - 1}
              >
                Next
              </button>
            </div>
          )}
        </>
      )}
    </div>
  )
}
