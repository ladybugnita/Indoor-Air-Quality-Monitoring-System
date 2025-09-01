import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import Layout from "./Layout";
import Home from "./Pages/Home";
import AdminLogin from "./Pages/AdminLogin";
import Dashboard from "./Pages/Dashboard";
import About from "./Pages/About";
import Contact from "./Pages/ContactUs";
import Recommendation from "./Components/Recommendation";
import Navbar from "./Components/Navbar";
import Sensor from "./Pages/Sensor";
import AdminDashboard from "./Pages/AdminDashboard";
import { IaqProvider } from "./Pages/IaqContext";
import PrivateRoute from "./Components/PrivateRoute";
import HealthForm from "./Pages/HealthForm";

function App() {
  return (
    <BrowserRouter>
      <IaqProvider>

      <Routes>
        {/* Admin login route without footer */}
        <Route
          path="/admin"
          element={
            <div>
              <Navbar />
              <AdminLogin />
            </div>
          }
        />
        
        {/* All other routes with Layout (includes footer) */}
        <Route path="/" element={<Layout />}>
          <Route index element={<Home hello="hello"/>} />
          <Route path="dashboard" element={<Dashboard />} />
          <Route path="about" element={<About />} />
          <Route path="contact" element={<Contact />} />
          <Route path="sensor" element={<Sensor />} />
          <Route path="recommendation" element={<Recommendation />} />
          <Route path="health" element={<HealthForm />} />
          <Route path="admin/dashboard" 
          element={
            <PrivateRoute>
              <AdminDashboard />
            </PrivateRoute>
             } 
          />
          
        </Route>
      </Routes>
      </IaqProvider>
    
    </BrowserRouter>
  );
}

export default App;
