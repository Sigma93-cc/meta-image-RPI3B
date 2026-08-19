DESCRIPTION = "SW Update bundle for sigmastudio distro"
LICENSE = "CLOSED"

# Add all local files to be added to the SWU
# sw-description must always be in the list.
# You can extend with scripts or whatever you need
SRC_URI = " \
    file://sw-description \
    "

# images to build before building swupdate image
IMAGE_DEPENDS = "my-image"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES = "my-image-${MACHINE}.rootfs.ext4.gz"
SWUPDATE_VERSION = "${DISTRO_VERSION}"
SWUPDATE_SIGNING = "RSA"
SWUPDATE_PRIVATE_KEY = "${LAYERDIR_meta-my}/dev-signing-key.pem"

inherit swupdate