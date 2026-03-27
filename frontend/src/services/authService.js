import api from './api'

export const authService = {
  register: async (email, password, name) => {
    const response = await api.post('/auth/register', {
      email,
      password,
      name,
    })
    return response.data
  },

  login: async (email, password) => {
    const response = await api.post('/auth/login', {
      email,
      password,
    })
    if (response.data.accessToken) {
      localStorage.setItem('accessToken', response.data.accessToken)
      localStorage.setItem('refreshToken', response.data.refreshToken)
    }
    return response.data
  },

  logout: () => {
    localStorage.removeItem('accessToken')
    localStorage.removeItem('refreshToken')
  },

  getToken: () => localStorage.getItem('accessToken'),
  isAuthenticated: () => !!localStorage.getItem('accessToken'),
}
