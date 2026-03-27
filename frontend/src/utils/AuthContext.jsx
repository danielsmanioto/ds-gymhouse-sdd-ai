import { useState } from 'react'
import { authService } from '../services/authService'
import { AuthContext } from './auth-context'

export function AuthProvider({ children }) {
  const [user, setUser] = useState(() =>
    authService.isAuthenticated() ? { authenticated: true } : null
  )
  const [error, setError] = useState(null)

  const register = async (email, password, name) => {
    try {
      setError(null)
      await authService.register(email, password, name)
      return true
    } catch (err) {
      setError(err.response?.data?.message || 'Registration failed')
      return false
    }
  }

  const login = async (email, password) => {
    try {
      setError(null)
      await authService.login(email, password)
      setUser({ authenticated: true, email })
      return true
    } catch (err) {
      setError(err.response?.data?.message || 'Login failed')
      return false
    }
  }

  const logout = () => {
    authService.logout()
    setUser(null)
  }

  const value = {
    user,
    loading: false,
    error,
    register,
    login,
    logout,
    isAuthenticated: !!user?.authenticated,
  }

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>
}
