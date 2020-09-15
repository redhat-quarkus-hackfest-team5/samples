package quarkus.hackfest.model;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = { Book.class, Author.class }, schemaPackageName = "quarkus.hackfest.model")
interface BookContextInitializer extends SerializationContextInitializer {
}
