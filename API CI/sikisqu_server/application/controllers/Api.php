<?php
defined('BASEPATH') OR exit('No direct script access allowed');


//Setting Currennt Date untuk lokasi di indonesia
class Api extends CI_Controller {
    function __construct(){
        parent::__construct();

        date_default_timezone_set('Asia/Jakarta');
        error_reporting(E_ALL);
        ini_set('display_errors',1);
    }

    //get Ticket
    function getTicket(){
      $orderticket = $this->input->post('orderticket');

      $this->db->where('status_bayar',0);
      $this->db->where('order_ticket',$orderticket);

      $q = $this->db->get('tb_ticket');

      if ($q->num_rows() > 0) {
          $data['message'] = 'success';
          $data['status'] = 200;
          $data['ticket'] = $q->result();
      } else {
          $data['message'] = 'tidak ditemukan';
          $data['status'] = 404;
      }

      echo json_encode($data);
    }
    
      //Update Data User
      function updateUser(){
        $idUser = $this->input->post('idUser');
        $hp = $this->input->post('hp');
        $alamat = $this->input->post('alamat');
        $nama = $this->input->post('nama');
        $password = $this->input->post('password');

        $this->db->where('id_user',$idUser);
        $simpan['user_hp'] = $hp;
        $simpan['user_alamat'] = $alamat;
        $simpan['user_nama'] = $nama;
        $simpan['user_password'] = md5($password);

        $q = $this->db->update('tb_user',$simpan);

        if($q){
            $data['message'] = 'login success';
            $data['satus'] = 200;
        } else {
            $data['message'] = 'login error';
            $data['satus'] = 404;
        }

        echo json_encode($data);
    }

    //Get Jadwal psikolog
    function getPsikolog(){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
      $q = $this->db->get('tb_psikolog');

      if($q -> num_rows() > 0) {
        $data['message'] = 'success';
        $data['status'] = 200;
        $data['psikolog'] = $q ->result();
      }
      else{
        $data['message'] = 'error';
        $data['status'] = 404;
      }
      echo json_encode($data);
    }

  

    //Fungsi Login()
    function loginUser(){
      $email = $this->input->post('email');
      $nohp = $this->input->post('nohp');
      $password = $this->input->post('password');
      

      $this->db->where('user_email',$email);
      $this->db->where('user_password',md5($password));
      $this->db->or_where('user_hp',$nohp);
      $this->db->where('user_password',md5($password));
      $this->db->where('user_level',1);

      $q = $this->db->get('tb_user');

      if($q -> num_rows() > 0){
          $data['message'] = 'Login Success';
          $data['status'] = 200;
          $data['user'] = $q -> row();
      } else {
          $data['message'] = 'Email atau Password Salah';
          $data['status'] = 404;
      }
      echo json_encode($data);
    }

    //Register User
    function registerUser(){
      $nama = $this->input->post('nama');
      $email = $this->input->post('email');
      $nohp = $this->input->post('nohp');
      $password = $this->input->post('password');
      $level = 1;

      $this->db->where('user_email',$email);
      $this->db->or_where('user_hp',$nohp);

      $q = $this->db->get('tb_user');
      if($q -> num_rows() > 0){
        $data['message'] = 'Email atau Hp sudah terdaftar, silahkan Sign In';
        $data['status'] = 404;
      } else {
          $simpan['user_nama'] = $nama;
          $simpan['user_email'] = $email;
          $simpan['user_hp'] = $nohp;
          $simpan['user_password'] = md5($password);
          $simpan['user_level'] = $level;

          $q = $this->db->insert('tb_user', $simpan);
          if($q){
            $data['message'] = 'success';
                $data['status'] = 200;
            } else {
                $data['message'] = 'error';
                $data['status'] = 404;
             
            }
        }
        echo json_encode($data);
      }
  
    //pesan e-ticket
   function newTicket(){
    $nobooking = $this->input->post('nobooking');
    $orderticket = $this->input->post('orderticket');
    $namapasien = $this->input->post('namapasien');
    $nohp = $this->input->post('nohp');
    $jenisperiksa = $this->input->post('jenisperiksa');
    $namapsikolog = $this->input->post('namapsikolog');

    $this->db->where('no_booking',$nobooking);

    $q = $this->db->get('tb_ticket');
    if($q -> num_rows() > 0){
      $data['message'] = 'No Booking Sudah terdaftar, silahkan Coba Lagi';
      $data['status'] = 404;
    } else {
        $simpan['no_booking'] = $nobooking;
        $simpan['order_ticket'] = $orderticket;
        $simpan['nama_pasien'] = $namapasien;
        $simpan['no_hp'] = $nohp;
        $simpan['jenis_periksa'] = $jenisperiksa;
        $simpan['waktu_periksa'] = date('Y-m-d');
        $simpan['nama_psikolog'] = $namapsikolog;

        $q = $this->db->insert('tb_ticket', $simpan);
        if($q){
          $data['message'] = 'success';
              $data['status'] = 200;
          } else {
              $data['message'] = 'error';
              $data['status'] = 404;
           
          }
      }
      echo json_encode($data);
  }

  
  }


