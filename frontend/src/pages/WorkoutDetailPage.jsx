import { useState, useEffect, useCallback } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import { workoutService } from '../services/workoutService'
import '../styles/WorkoutDetail.css'

export function WorkoutDetailPage() {
  const { workoutId } = useParams()
  const navigate = useNavigate()
  const [workout, setWorkout] = useState(null)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  const fetchWorkoutDetail = useCallback(async () => {
    try {
      setLoading(true)
      setError('')
      const data = await workoutService.getWorkoutById(workoutId)
      setWorkout(data)
    } catch (err) {
      setError('Failed to load workout details')
      console.error(err)
    } finally {
      setLoading(false)
    }
  }, [workoutId])

  useEffect(() => {
    fetchWorkoutDetail()
  }, [fetchWorkoutDetail])

  if (loading) {
    return (
      <div className="detail-container">
        <div className="loading-message">Loading workout details...</div>
      </div>
    )
  }

  if (error || !workout) {
    return (
      <div className="detail-container">
        <button onClick={() => navigate('/workouts')} className="btn-back">
          ← Back to Workouts
        </button>
        <div className="error-message">{error || 'Workout not found'}</div>
      </div>
    )
  }

  return (
    <div className="detail-container">
      <button onClick={() => navigate('/workouts')} className="btn-back">
        ← Back to Workouts
      </button>

      <div className="detail-card">
        <div className="detail-header">
          <h1>{workout.name}</h1>
          <span className="detail-category">{workout.category}</span>
        </div>

        <div className="detail-meta">
          <div className="meta-item">
            <strong>Difficulty:</strong> {workout.difficulty}
          </div>
          <div className="meta-item">
            <strong>Duration:</strong> {workout.durationMinutes} minutes
          </div>
          <div className="meta-item">
            <strong>Target Muscles:</strong> {workout.targetMuscles?.join(', ') || 'N/A'}
          </div>
        </div>

        <div className="detail-section">
          <h2>Description</h2>
          <p>{workout.description}</p>
        </div>

        {workout.instructions && (
          <div className="detail-section">
            <h2>Instructions</h2>
            <p>{workout.instructions}</p>
          </div>
        )}

        {workout.exercises && Array.isArray(workout.exercises) && (
          <div className="detail-section">
            <h2>Exercises</h2>
            <ol className="exercises-list">
              {workout.exercises.map((exercise, idx) => (
                <li key={idx}>
                  <strong>{exercise.name}</strong>
                  <p>{exercise.description}</p>
                  <span className="exercise-meta">
                    {exercise.sets} sets × {exercise.reps} reps
                  </span>
                </li>
              ))}
            </ol>
          </div>
        )}

        <button
          onClick={() => console.log('Start workout:', workout.id)}
          className="btn-primary"
        >
          Start Workout
        </button>
      </div>
    </div>
  )
}
