import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';


import ChooseService from './components/ChooseService'
import AppNotificationComponent from './components/app-notification/app-notification-component'
import LoadingIndicatorComponent from './components/loader/loading-indicator-component';

function App() {
  return (
  <div>
    <LoadingIndicatorComponent></LoadingIndicatorComponent>
    <nav className="navbar navbar-light bg-dark navbar-expand-md">
        <a className="navbar-brand text-light" href="/">AR Salon and Day Spa Services</a>
      </nav>
      <main role="main" className="container">
          <div className="padding-container">
       <ChooseService></ChooseService>
          </div>
        </main>
          <AppNotificationComponent></AppNotificationComponent>
  </div>);
}

export default App;
