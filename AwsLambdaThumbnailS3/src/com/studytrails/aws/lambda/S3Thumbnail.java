package com.studytrails.aws.lambda;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.event.S3EventNotification.S3Entity;
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord;
import com.amazonaws.services.s3.event.S3EventNotification.S3ObjectEntity;

public class S3Thumbnail {

	void createThumbnail(S3Event event, Context context) {
		LambdaLogger logger = context.getLogger();
		List<S3EventNotificationRecord> eventRecords = event.getRecords();
		for (S3EventNotificationRecord record : eventRecords) {
			S3Entity entity = record.getS3();
			S3ObjectEntity objectEntity = entity.getObject();
			logger.log(objectEntity.getKey());
		}
	}

}
