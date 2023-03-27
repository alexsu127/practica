package com.example.subscription.repository;


import com.example.subscription.entity.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
}
