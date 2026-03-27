import api from './api'

export const workoutService = {
  getWorkouts: async (page = 0, size = 10, search = '', category = '') => {
    const params = {
      page,
      size,
    }
    if (search) params.search = search
    if (category) params.category = category

    const response = await api.get('/workouts', { params })
    return response.data
  },

  getWorkoutById: async (workoutId) => {
    const response = await api.get(`/workouts/${workoutId}`)
    return response.data
  },
}
