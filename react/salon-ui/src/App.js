import React from 'react';
import './App.css';

import ServicesBox from './components/ServicesBox'
import Service from './components/Service'

import 'bootstrap/dist/css/bootstrap.min.css';

const data = [{"id":1,"description":"Anti-aging Treatments from AR Salon","name":"Anti-aging Treatments","price":148,"time_in_minutes":70},{"id":2,"description":"Body Massages from AR Salon","name":"Body Massages","price":107,"time_in_minutes":110},{"id":3,"description":"Body Treatments from AR Salon","name":"Body Treatments","price":129,"time_in_minutes":90},{"id":4,"description":"Facial Massages from AR Salon","name":"Facial Massages","price":122,"time_in_minutes":70},{"id":5,"description":"Feet Treatments from AR Salon","name":"Feet Treatments","price":176,"time_in_minutes":60},{"id":6,"description":"LED Light Treatments from AR Salon","name":"LED Light Treatments","price":14,"time_in_minutes":30},{"id":7,"description":"Acupressure Massage from AR Salon","name":"Acupressure Massage","price":125,"time_in_minutes":60},{"id":8,"description":"Reflexology from AR Salon","name":"Reflexology","price":183,"time_in_minutes":40},{"id":9,"description":"Pore Cleansing Treatments from AR Salon","name":"Pore Cleansing Treatments","price":127,"time_in_minutes":120},{"id":10,"description":"Wrinkle Treatments from AR Salon","name":"Wrinkle Treatments","price":196,"time_in_minutes":110},{"id":11,"description":"Back Treatments from AR Salon","name":"Back Treatments","price":11,"time_in_minutes":50},{"id":12,"description":"Body Scrubs from AR Salon","name":"Body Scrubs","price":109,"time_in_minutes":60},{"id":13,"description":"Body Wraps from AR Salon","name":"Body Wraps","price":116,"time_in_minutes":110},{"id":14,"description":"Facial Treatments from AR Salon","name":"Facial Treatments","price":34,"time_in_minutes":70},{"id":15,"description":"Hand Treatments from AR Salon","name":"Hand Treatments","price":149,"time_in_minutes":40},{"id":16,"description":"Mask Treatments from AR Salon","name":"Mask Treatments","price":44,"time_in_minutes":60},{"id":17,"description":"Deep Tissue Massage from AR Salon","name":"Deep Tissue Massage","price":20,"time_in_minutes":80},{"id":18,"description":"Swedish Massage from AR Salon","name":"Swedish Massage","price":45,"time_in_minutes":30},{"id":19,"description":"Brightening Treatments from AR Salon","name":"Brightening Treatments","price":87,"time_in_minutes":60},{"id":20,"description":"Couples Massage from AR Salon","name":"Couples Massage","price":54,"time_in_minutes":90},{"id":21,"description":"Hot Stone Massage from AR Salon","name":"Hot Stone Massage","price":29,"time_in_minutes":60},{"id":22,"description":"Eyebrow Services from AR Salon","name":"Eyebrow Services","price":200,"time_in_minutes":110},{"id":23,"description":"Eye Treatments from AR Salon","name":"Eye Treatments","price":187,"time_in_minutes":90},{"id":24,"description":"Skin Extractions from AR Salon","name":"Skin Extractions","price":48,"time_in_minutes":70}]

function App() {
  return (
    <div className="App">
      <nav className="navbar navbar-light bg-dark navbar-expand-md">
        <a className="navbar-brand text-light" href="/">AR Salon and Day Spa Services</a>
      </nav>
      <main role="main" className="container">
          <ServicesBox services={data}/>
        </main>
       
    </div>
  );
}

export default App;
