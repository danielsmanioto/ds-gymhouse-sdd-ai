# DS Gym House - Frontend

React + Vite frontend para o DS Gym House API.

## Quick Start

### Setup
```bash
npm install
cp .env.example .env
```

### Development
```bash
npm run dev
```

A aplicação rodará em `http://localhost:5173`

### Build
```bash
npm run build
npm run preview
```

## Project Structure

```
src/
├── pages/             # Page components
│   ├── AuthPage.jsx       # Login/Register
│   ├── CatalogPage.jsx    # Workout catalog
│   └── WorkoutDetailPage.jsx  # Workout details
├── services/          # API services
│   ├── api.js            # Axios instance with interceptors
│   ├── authService.js    # Auth API calls
│   └── workoutService.js # Workout API calls
├── utils/             # Utilities
│   ├── AuthContext.jsx    # Auth state management
│   └── PrivateRoute.jsx   # Protected routes
├── styles/            # CSS files
│   ├── globals.css       # Global styles
│   ├── Auth.css          # Auth page styles
│   ├── Catalog.css       # Catalog page styles
│   └── WorkoutDetail.css # Detail page styles
├── App.jsx            # Main app with routing
└── main.jsx           # Entry point
```

## Features

### ✅ Implemented
- **Authentication**: Register, Login with JWT tokens
- **Workout Catalog**: List workouts with pagination
- **Workout Details**: View detailed workout information
- **Responsive Design**: Dark theme with gradient accents
- **Protected Routes**: Routes require authentication
- **API Integration**: Axios with token management

## Environment Variables

```env
VITE_API_URL=http://localhost:8080/api/v1
```

## Development Notes

- Uses React Router for navigation
- JWT tokens stored in localStorage
- Automatic token refresh on 401 error
- Dark mode UI with Indigo/Pink gradients
